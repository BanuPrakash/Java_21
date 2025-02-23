//java -XX:StartFlightRecording:filename=sample.jfr FlightRecorderExample.java
// jfr print --events FileUpload  sample.jfr
// jmc
import jdk.jfr.Category;
        import jdk.jfr.DataAmount;
        import jdk.jfr.Event;
        import jdk.jfr.Label;
        import jdk.jfr.Name;
        import jdk.jfr.Percentage;

public class FlightRecorderExample  {

    public static final String PROGRAMMERS_GUIDE_SAMPLES =
            "Programmer's Guide Samples";
    public static final String UPLOAD = "Upload";
    public static final String IMAGE_UPLOAD = "Image Upload";
    public static final String JAVA_APPLICATION = "Java Application";

    @Name("com.oracle.FileUpload")
    @Label("File Upload")
    @Category({PROGRAMMERS_GUIDE_SAMPLES, UPLOAD})
    private static class FileUpload extends Event { }

    @Name("com.oracle.ImageRead")
    @Label("Image Read")
    @Category({PROGRAMMERS_GUIDE_SAMPLES, IMAGE_UPLOAD})
    private static class ImageRead extends Event {
        @DataAmount(DataAmount.BYTES)
        long bytesUploaded;
    }

    @Name("com.oracle.ImageResize")
    @Label("Image Resize")
    @Category({PROGRAMMERS_GUIDE_SAMPLES, IMAGE_UPLOAD})
    private static class ImageResize extends Event {
        @Percentage
        double scale;
    }

    @Name("com.oracle.ImageWrite")
    @Label("Image Write")
    @Category({PROGRAMMERS_GUIDE_SAMPLES, IMAGE_UPLOAD})
    private static class ImageWrite extends Event {
        @DataAmount(DataAmount.BYTES)
        long bytesWritten;
    }

    @Name("com.oracle.SocketRead")
    @Label("Socket Read")
    @Category({PROGRAMMERS_GUIDE_SAMPLES, JAVA_APPLICATION})
    private static class SocketRead extends Event {
        @DataAmount(DataAmount.BYTES)
        long bytesRead;
    }

    @Name("com.oracle.FileWrite")
    @Label("File Write")
    @Category({PROGRAMMERS_GUIDE_SAMPLES, JAVA_APPLICATION})
    private static class FileWrite extends Event {
        @DataAmount(DataAmount.BYTES)
        long bytesWritten;
    }

    public static void main(String... args) {
        FileUpload fu = new FileUpload();
        fu.begin();

        ImageRead ir = new ImageRead();
        ir.begin();
        ir.bytesUploaded = 2048;

        SocketRead sr1 = new SocketRead();
        sr1.begin();
        sr1.bytesRead = 1024;
        sr1.commit();

        SocketRead sr2 = new SocketRead();
        sr2.begin();
        sr2.bytesRead = 1024;
        sr2.commit();

        ir.commit();

        ImageResize irs = new ImageResize();
        irs.begin();
        irs.scale = 0.5;
        irs.commit();

        ImageWrite iw = new ImageWrite();
        iw.begin();
        iw.bytesWritten = 1024;

        FileWrite fw = new FileWrite();
        fw.begin();
        fw.bytesWritten = 1024;
        fw.commit();

        iw.commit();
        fu.commit();
    }
}
