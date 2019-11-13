package com.mobiliya.workshop.dataflow.pipeline.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class ErrorLog implements Serializable {

    private String date;
    private String time;
    private String server;
    private String serverPort;
    private String clientHost;
    private String clientPort;
    private String protocol;
    private String httpMethod;
    private String errorFromFile;
    private String errorCode;
    private String ErrorDesc;
    private Timestamp currentDateTime;

    public Timestamp getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(Timestamp currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getClientHost() {
        return clientHost;
    }

    public void setClientHost(String clientHost) {
        this.clientHost = clientHost;
    }

    public String getClientPort() {
        return clientPort;
    }

    public void setClientPort(String clientPort) {
        this.clientPort = clientPort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getErrorFromFile() {
        return errorFromFile;
    }

    public void setErrorFromFile(String errorFromFile) {
        this.errorFromFile = errorFromFile;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return ErrorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        ErrorDesc = errorDesc;
    }

    @Override
    public String toString() {
        return "ErrorLog{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", server='" + server + '\'' +
                ", serverPort='" + serverPort + '\'' +
                ", clientHost='" + clientHost + '\'' +
                ", clientPort='" + clientPort + '\'' +
                ", protocol='" + protocol + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", errorFromFile='" + errorFromFile + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", ErrorDesc='" + ErrorDesc + '\'' +
                ", currentDateTime=" + currentDateTime +
                '}';
    }
}
