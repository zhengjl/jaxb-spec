/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package jaxb.factory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import java.util.Map;

/**
 * Valid JAXBContext factory class for tests
 * - contains required static methods and creates dummy JAXBContext
 */
public class Valid {

    public static JAXBContext createContext(java.lang.String path, java.lang.ClassLoader cl) {
        return new PropValidJAXBContext();
    }

    public static JAXBContext createContext(Class[] classes, Map<String, Object> properties) throws JAXBException {
        return new PropValidJAXBContext();
    }


    public static class PropValidJAXBContext extends JAXBContext {

        @Override
        public Unmarshaller createUnmarshaller() throws JAXBException {
            return null;
        }

        @Override
        public Marshaller createMarshaller() throws JAXBException {
            return null;
        }

        @Override
        public Validator createValidator() throws JAXBException {
            return null;
        }
    }
}
