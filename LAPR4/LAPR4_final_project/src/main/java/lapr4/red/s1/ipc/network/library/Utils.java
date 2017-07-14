/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import java.io.File;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 *
 *
 *
 */
public class Utils {

    /**
     * separator for
     */
    public final static String SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT = "@";

    private static final String ERROR_RETURN_DEFAULT = "127.0.0.2";
    private static final String LOCALHOST_DEFAULT = "127.0.0.1";

    private static final String ERROR_MASK_172_RETURN_DEFAULT = "127.255.255.255";
    private static final String ERROR_MASK_192_RETURN_DEFAULT = "192.255.255.255";

    private final static String REGEX_PUBLIC_IP_ADDRESS_DEFAULT = "^([0-9]|"
            + "[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])(?<!172\\.(16|17|18|19"
            + "|20|21|22|23|24|25|26|27|28|29|30|31))(?<!127)(?<!^10)(?<!^0)\\."
            + "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])(?<!192\\.168)(?<"
            + "!172\\.(16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31))\\.([0-9]|"
            + "[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9]"
            + "{2}|2[0-4][0-9]|25[0-5])(?<!\\.0$)(?<!\\.255$)$";

    /**
     * in a list only returns the ones that are "ivp4" ou "ipv6" protocol, as
     * asked
     *
     * "mask" or "address" or "broadcast"
     *
     *
     *
     * @param ipv4Ipv6
     * @param maskOrAddress
     * @param ipList
     * @return
     */
    private static String cleanIpString(NetworkIpProtocolEnum ipv4Ipv6, String maskOrAddress, ArrayList<String> ipList) {
        for (String s : ipList) {
            if (ipv4Ipv6.equals(NetworkIpProtocolEnum.IPV4)) {
                if (maskOrAddress.equalsIgnoreCase("mask")) {
                    if (s.matches("\\/[1-3]?[0-9]")) {
                        /*validate cases like: "/31", "/9" etc*/
                        return s;

                    }
                } else if (maskOrAddress.equalsIgnoreCase("address")) {
                    s = s.trim();
                    s = s.replaceAll("/", "");
                    if (validateAddress(s, NetworkIpProtocolEnum.IPV4)) {
                        /**
                         * ignore loopback address
                         */
                        if (!s.matches(REGEX_PUBLIC_IP_ADDRESS_DEFAULT) && !s.contains(LOCALHOST_DEFAULT)) {
                            return s;
                        }
                    }
                } else if (maskOrAddress.equalsIgnoreCase("broadcast")) {
                    /**
                     * if is broadcast address
                     */
                    if (s.charAt(0) == '/') {
                        StringBuilder tmp = new StringBuilder(s);
                        tmp.deleteCharAt(0);
                        s = tmp.toString();
                    }
                    if (validateAddress(s, NetworkIpProtocolEnum.IPV4)
                            && !s.equalsIgnoreCase(ERROR_MASK_172_RETURN_DEFAULT)
                            && !s.equalsIgnoreCase(ERROR_MASK_192_RETURN_DEFAULT)) {
                        /*ALTERA PORRA*/
                        return s;
                    }
                }
            } else if (ipv4Ipv6.equals(NetworkIpProtocolEnum.IPV6)) {
                /*not implemented*/
            }
        }
        return ERROR_RETURN_DEFAULT;
        /*default, never local host*/
    }

    /**
     * "ipv4" OR "ipv6"
     *
     * @param ipProtocol
     * @return
     */
    public static String getMachineIpAddress(NetworkIpProtocolEnum ipProtocol) {
        ArrayList<String> ipList = new ArrayList<>();
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    ipList.add(i.getHostAddress());
                }
            }
        } catch (SocketException e) {
            System.out.println();
            System.out.println("--> SOCKET ERROR EXCEPTION: " + e.toString());
        }

        return cleanIpString(ipProtocol, "address", ipList);
    }

    public static String getMachineBroadcastAddressIpv4() {
        return returnMachineBroadcastOrSubnetMaskAddress(NetworkIpProtocolEnum.IPV4, "broadcast");
    }

    public static String getMachineMaskAddressIpv4() {
        return returnMachineBroadcastOrSubnetMaskAddress(NetworkIpProtocolEnum.IPV4, "mask");
    }

    /**
     * "ipv4" OR "ipv6"
     *
     * "broadcast" OR "mask"
     *
     * @param ipv4Ipv6
     * @return
     */
    private static String returnMachineBroadcastOrSubnetMaskAddress(NetworkIpProtocolEnum ipv4Ipv6, String BroadcastOrSubnetMask) {
        ArrayList<String> ipList = new ArrayList<>();
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                List<InterfaceAddress> ee = n.getInterfaceAddresses();
                Iterator<InterfaceAddress> it = ee.iterator();
                while (it.hasNext()) {
                    //InetAddress i = (InetAddress) ee.nextElement();
                    InterfaceAddress ia = it.next();
                    if (BroadcastOrSubnetMask.equalsIgnoreCase("broadcast")) {
                        InetAddress inet = ia.getBroadcast();
                        if (inet != null) {
                            ipList.add(ia.getBroadcast().toString());
                        }
                    } else if (BroadcastOrSubnetMask.equalsIgnoreCase("mask")) {
                        ipList.add("/" + ia.getNetworkPrefixLength());
                    }
                }
            }
        } catch (SocketException e) {
            //System.out.println("SOCKET ERROR EXCEPTION: " + e.toString());
            System.out.println("SOCKET ERROR EXCEPTION: " + e.toString());
        }

        return (BroadcastOrSubnetMask.equalsIgnoreCase("broadcast"))
                ? cleanIpString(ipv4Ipv6, BroadcastOrSubnetMask, ipList)
                : cleanIpString(ipv4Ipv6, "mask", ipList);
    }

    /**
     *
     * ADDRESS TYPE --> addressType: "ipv4" OR "ipv6"
     *
     * @param address
     * @param addressType
     * @return
     */
    public static boolean validateAddress(String address, NetworkIpProtocolEnum addressType) {
        boolean toReturn = false;
        String regex = "";
        if (addressType.equals(NetworkIpProtocolEnum.IPV4)) {
            /*IPV4*/
            regex
                    = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
            /*regex origin: https://www.mkyong.com/regular-expressions/how-to-validate-ip-address-with-regular-expression/*/
        } else if (addressType.equals(NetworkIpProtocolEnum.IPV6)) {
            /*IPV6*/
            regex = "(\\A([0-9a-f]{1,4}:){1,1}(:[0-9a-f]{1,4}){1,6}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,2}(:[0-9a-f]{1,4}){1,5}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,3}(:[0-9a-f]{1,4}){1,4}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,4}(:[0-9a-f]{1,4}){1,3}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,5}(:[0-9a-f]{1,4}){1,2}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,6}(:[0-9a-f]{1,4}){1,1}\\Z)|"
                    + "(\\A(([0-9a-f]{1,4}:){1,7}|:):\\Z)|"
                    + "(\\A:(:[0-9a-f]{1,4}){1,7}\\Z)|"
                    + "(\\A((([0-9a-f]{1,4}:){6})(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3})\\Z)|"
                    + "(\\A(([0-9a-f]{1,4}:){5}[0-9a-f]{1,4}:(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3})\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){5}:[0-9a-f]{1,4}:(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,1}(:[0-9a-f]{1,4}){1,4}:(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,2}(:[0-9a-f]{1,4}){1,3}:(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,3}(:[0-9a-f]{1,4}){1,2}:(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\Z)|"
                    + "(\\A([0-9a-f]{1,4}:){1,4}(:[0-9a-f]{1,4}){1,1}:(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\Z)|"
                    + "(\\A(([0-9a-f]{1,4}:){1,5}|:):(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\Z)|"
                    + "(\\A:(:[0-9a-f]{1,4}){1,5}:(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\Z)";
            /*REGEX origin: http://vernon.mauery.com/content/projects/linux/ipv6_regex*/
        } else {
            return false;
        }
        return address.matches(regex);
    }

    public static ArrayList<String> listAllFilesStringList(ArrayList<File> listAllFiles) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (File f : listAllFiles) {
            toReturn.add(f.getName());
        }
        if (toReturn.isEmpty()) {
            toReturn.add("Empty directory");
        }
        return toReturn;
    }

    /**
     * returns the own machine address information
     *
     * OS FORMAT:
     *
     *
     * inet 172.18.135.71 netmask 255.255.248.0 broadcast 172.18.135.255 inet6
     * fe80::6368:4298:ecfe:8d1f prefixlen 64 scopeid 0x20<link>
     * ether 24:77:03:eb:1d:80 txqueuelen 1000 (Ethernet)
     *
     *
     * @return
     */
    public static NetworkAddress ownIpAddress() {
        String address = getMachineIpAddress(NetworkIpProtocolEnum.IPV4);
        String maskAddress = getMachineMaskAddressIpv4();
        String broadcastAddress = getMachineBroadcastAddressIpv4();
        NetworkAddress toReturn = new NetworkAddress(NetworkIpProtocolEnum.IPV4, address,
                maskAddress, broadcastAddress,
                -1,
                -1);
        return toReturn;
    }

    public static ArrayList<String> sizeOfEachFile(ArrayList<File> files) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (File f : files) {
            toReturn.add(bytesToHumanFormat(f.length()));
        }
        return toReturn;
    }

    private static String bytesToHumanFormat(long size) {
        long Kb = 1 * 1024;
        long Mb = Kb * 1024;
        long Gb = Mb * 1024;
        long Tb = Gb * 1024;
        long Pb = Tb * 1024;
        long Eb = Pb * 1024;

        if (size < Kb) {
            return floatForm(size) + " byte";
        }
        if (size >= Kb && size < Mb) {
            return floatForm((double) size / Kb) + " Kb";
        }
        if (size >= Mb && size < Gb) {
            return floatForm((double) size / Mb) + " Mb";
        }
        if (size >= Gb && size < Tb) {
            return floatForm((double) size / Gb) + " Gb";
        }
        if (size >= Tb && size < Pb) {
            return floatForm((double) size / Tb) + " Tb";
        }
        if (size >= Pb && size < Eb) {
            return floatForm((double) size / Pb) + " Pb";
        }
        if (size >= Eb) {
            return floatForm((double) size / Eb) + " Eb";
        }

        return "ERRO";
    }

    public static String floatForm(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    /**
     * to ignore if is own IP
     *
     * @param address
     * @return
     */
    public static boolean isOwnIp(NetworkAddress address) {
        return ownIpAddress().getAddress().equalsIgnoreCase(address.getAddress());
    }
}
