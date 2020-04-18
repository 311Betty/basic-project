package com.betty.tinyioc.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public interface Resource {
    InputStream getInputStream() throws IOException;
}
