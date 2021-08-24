package org.newdawn.slick.util;

import java.net.*;
import java.io.*;

public class ClasspathLocation implements ResourceLocation
{
    public URL getResource(final String ref) {
        final String cpRef = ref.replace('\\', '/');
        return ResourceLoader.class.getClassLoader().getResource(cpRef);
    }
    
    public InputStream getResourceAsStream(final String ref) {
        final String cpRef = ref.replace('\\', '/');
        return ResourceLoader.class.getClassLoader().getResourceAsStream(cpRef);
    }
}
