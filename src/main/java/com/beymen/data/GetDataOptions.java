package com.beymen.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import core.utility.Logging;
import lombok.Data;
import java.io.File;

@Data
public class GetDataOptions {

    private String[] options;


    private static GetDataOptions data;

    static {

        if (data == null) {

            try {

                ObjectMapper om = new ObjectMapper(new YAMLFactory());
                data = om.readValue(
                        new File("src/main/resources/options.yaml"),
                        GetDataOptions.class);

            } catch (Exception e) {
                Logging.fail("A problem was encountered reading the options.yaml file!");
            }
        }
    }

    public static GetDataOptions getParameters() {
        Logging.pass(data);
        return data;
    }
}
