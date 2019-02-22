ps -ef | grep 'samplesignalreceiver' | grep -v grep | awk '{print $2}' | xargs -r kill -SIGUSR2
