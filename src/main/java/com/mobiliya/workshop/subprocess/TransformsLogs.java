package com.mobiliya.workshop.subprocess;

import com.mobiliya.workshop.dataflow.pipeline.entities.ErrorLog;
import org.apache.beam.sdk.transforms.DoFn;

import java.util.Date;
import java.sql.Timestamp;

public class TransformsLogs extends DoFn<String, ErrorLog> {
    @ProcessElement
    public void processElement(@Element String line, OutputReceiver<ErrorLog> out) {
        System.err.println(line);
        String[] strArr = line.split(" ");
        ErrorLog obj = new ErrorLog();
        Date date= new Date();
        long time = date. getTime();

        obj.setDate(strArr[0]);
        obj.setTime(strArr[1]);
        obj.setServer(strArr[2]);
        obj.setServerPort(strArr[3]);
        obj.setClientHost(strArr[4]);
        obj.setClientPort(strArr[5]);
        obj.setProtocol(strArr[6]);
        obj.setHttpMethod(strArr[7]);
        obj.setErrorFromFile(strArr[8]);
        obj.setErrorCode(strArr[9]);
        obj.setErrorDesc(strArr[11]);
        obj.setCurrentDateTime(new java.sql.Timestamp(time));


        out.output(obj);
    }

}
