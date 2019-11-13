package com.mobiliya.workshop.subprocess;

import com.mobiliya.workshop.dataflow.pipeline.entities.ErrorLog;
import org.apache.beam.sdk.transforms.DoFn;

import java.time.Instant;

public class AddTimeStamp extends DoFn<ErrorLog, ErrorLog> {
    @ProcessElement
    public void processElement(@Element ErrorLog line, OutputReceiver<ErrorLog> out) {

        // Extract the timestamp from log entry we're currently processing.
    //    Instant logTimeStamp = extractTimeStampFromLogEntry(line);
        // Use OutputReceiver.outputWithTimestamp (rather than
        // OutputReceiver.output) to emit the entry with timestamp attached.
      //  out.outputWithTimestamp(element, logTimeStamp);
    }

}
