public sealed interface TrafficLight { // permits is optional if all are within same file
    String getData();
}

final class Red implements TrafficLight {
    @Override
    public String getData() {
        return "Stop";
    }
}

final class Green implements TrafficLight {
    @Override
    public String getData() {
        return "Go";
    }
}

final class Yellow implements TrafficLight {
    @Override
    public String getData() {
        return "Ready";
    }
}