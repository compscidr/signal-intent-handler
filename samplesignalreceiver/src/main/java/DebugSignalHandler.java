import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * This class needs to be compiled into libjavacore
 */
class DebugSignalHandler implements SignalHandler
{
    public static void listenTo(String name) {
        Signal signal = new Signal(name);
        Signal.handle(signal, new DebugSignalHandler());
    }

    public void handle(Signal signal) {
        if (signal.toString().trim().equals("SIGUSR2")) {
            /// insert code here to call xhist.write ///
        }

        if (signal.toString().trim().equals("SIGTERM")) {
            System.out.println("SIGTERM raised, terminating...");
            System.exit(1);
        }
    }
}