public class TrafficLightExample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new Red();
        String result = switch (trafficLight) {
            case Red r-> r.getData();
            case Green g -> g.getData();
            case Yellow y -> y.getData();

        };

        System.out.println(result);

    }

    public static String getInfo(String data) {
        return switch (data) {
            case "a", "b" -> "Stop";
            case "c" -> "Go";
            default -> "Invalid";
        };
    }
}
