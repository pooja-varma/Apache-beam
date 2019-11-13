package com.mobiliya.workshop.dataflow.pipeline;


import com.mobiliya.workshop.dataflow.pipeline.entities.ErrorLog;
import com.mobiliya.workshop.subprocess.AddTimeStamp;
import com.mobiliya.workshop.subprocess.KafkaPublish;
import com.mobiliya.workshop.subprocess.TransformsLogs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.transforms.InferableFunction;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import java.io.Serializable;


public class DataflowPipelineBuilder implements Serializable {

    private static String KAFKA_SERVER = "localhost:9092";
    private static int WINDOW_INTERVAL = 120;


    public Pipeline createDataPipeline(String[] args) {

        PipelineOptions options =
                PipelineOptionsFactory.fromArgs(args).create();

        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> logLines =
                // The input PCollection is an empty pipeline.
                pipeline.apply("Read lines", TextIO.read().from("D:\\inputData.txt"));

        //adding current timestamp
        PCollection<ErrorLog> errorLogObj= logLines.apply(ParDo.of(new TransformsLogs()));

        //apply group by based on error code
        // readings for a given route.

        PCollection<KV<String, String>> parseAndConvertToKV = errorLogObj.apply(
                MapElements.via(new InferableFunction<ErrorLog, KV<String, String>>() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public KV<String, String> apply(ErrorLog input) {
                        String errorCode =input.getErrorCode();
                        return KV.of(errorCode, input.toString());
                    }
                }));


//
//        parseAndConvertToKV.apply(KafkaIO.<String, String>write()
//                .withBootstrapServers("localhost:9092")
//                .withTopic("500")
//                .withKeySerializer(StringSerializer.class)
//                .withValueSerializer(StringSerializer.class));

    //    PCollection<KV<String, Iterable<ErrorLog>>> groupByErrorCode =
       //         parseAndConvertToKV.apply(GroupByKey.create());
        //     errorLogObj.apply(ParDo.of(new AddTimeStamp()));




        return pipeline;
    }
}
