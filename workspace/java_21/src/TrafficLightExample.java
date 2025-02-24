public class TrafficLightExample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new Red();
        String result = switch (trafficLight) {
            case Red r-> r.getData();
            case Green g -> g.getData();
            case Yellow y -> y.getData();

        };

        System.out.println(result);

        // Enhanced instanceof

        Object obj = new String("Hello World");

        if(obj instanceof String s) {
            System.out.println(s.length());
        }

    }

    public static String getInfo(String data) {
        return switch (data) {
            case "a", "b" -> "Stop";
            case "c" -> "Go";
            default -> "Invalid";
        };
    }

    public static String getInformation(String data) {
        return switch (data) {
            case "a", "b" : {
                System.out.println("Inside a or b");
                yield "Stop";
            }
            case "c" : yield  "Go";
            default : yield "Invalid";
        };
    }
}
