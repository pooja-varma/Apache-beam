package com.mobiliya.workshop.subprocess;

import com.mobiliya.workshop.dataflow.pipeline.entities.ErrorLog;
import org.apache.beam.sdk.transforms.DoFn;

public class KafkaPublish extends DoFn<String, String> {
    @ProcessElement
    public void processElement(@Element String errorCode, OutputReceiver<String> out) {

            if(errorCode=="500"){

            }



    }

}
