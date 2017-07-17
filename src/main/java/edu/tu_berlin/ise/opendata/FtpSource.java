package edu.tu_berlin.ise.opendata;

import java.io.*;
import java.util.stream.Stream;

import javax.annotation.Nonnull;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by aardila on 7/14/17.
 */
public class FtpSource implements AutoCloseable {

    private String hostname;
    FTPClient ftpClient;

    public FtpSource(@Nonnull String hostname) {

        if (hostname == null || hostname.isEmpty()) {
            throw new IllegalArgumentException("hostname");
        }
        this.hostname = hostname;
        this.ftpClient = new FTPClient();
    }

    public Stream<String> getStream(@Nonnull String file, @Nonnull String charsetName) throws IOException {

        ftpClient.connect(hostname);
        ftpClient.user("anonymous");
        ftpClient.pass("anon@anon.org");
        System.out.println(ftpClient.getReplyString());
        ftpClient.enterLocalPassiveMode(); //prevents FTP response code 500
        BufferedReader reader = null;

        InputStream inputStream = ftpClient.retrieveFileStream(file);
        System.out.println(ftpClient.getReplyString());
        InputStreamReader streamReader = new InputStreamReader(inputStream, charsetName);
        reader = new BufferedReader(streamReader);

        //remove first line
        String firstLine = reader.readLine();

        return reader.lines();
    }

    @Override
    public void close() throws Exception {
        ftpClient.disconnect();
    }
}
