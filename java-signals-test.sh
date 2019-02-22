#!/bin/bash

# Get temp dir
tmpdir=$(mktemp -d)

# Generate test
cat > ${tmpdir}/ListenToSignal.java <<EOF
import sun.misc.Signal;
import sun.misc.SignalHandler;
public class ListenToSignal {
    public static void main(String[] args) {
        try {
            Signal.handle(new Signal(args[0]), new SignalHandler() {
                public void handle(Signal sig) {
                    System.out.println(sig.getName() + ": yes");
                    System.exit(0);
                }
            });
            Thread.sleep(5000L);
            System.out.println(args[0] + ": no");
        } catch (Throwable t) {
            System.out.println(args[0] + ": no (" + t.getMessage() + ")");
        }
        System.exit(1);
    }
}
EOF

# Compile test
javac ${tmpdir}/ListenToSignal.java &>/dev/null

# Get signals, test each one of them
for signal in $(kill -l | grep -Po '(?<=SIG)[^\s]+'); do
  java -cp ${tmpdir} ListenToSignal $signal &  # Start program in background
  sleep 2                                      # Make sure it is ready
  kill -s $signal $! &>/dev/null               # Send signal
  wait                                         # Wait to termination
done
