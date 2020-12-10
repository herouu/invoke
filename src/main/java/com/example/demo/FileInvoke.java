package com.example.demo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import static org.springframework.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

@Slf4j
public class FileInvoke {

    @Value("${file.path}")
    private String filePath;

    @SneakyThrows
    public void invokeFile() {
        if (StringUtils.hasText(filePath)) {
            if (filePath.startsWith(CLASSPATH_URL_PREFIX)) {
                filePath = filePath.substring(CLASSPATH_URL_PREFIX.length());
            }
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
            StringBuffer sb = new StringBuffer();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            log.info(sb.toString());
            // log.info("路径:{}", path);
        }

    }
}
