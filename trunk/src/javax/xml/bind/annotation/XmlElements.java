/*
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.bind.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p>
 * A container for multiple @{@link XmlElement} annotations.
 *
 * Multiple annotations of the same type are not allowed on a program
 * element. This annotation therefore serves as a container annotation
 * for multiple &#64;XmlElements as follows:
 *
 * <pre>
 * &#64;XmlElements({ @XmlElement(...),@XmlElement(...) })
 * </pre>
 *
 * <p>The <tt>@XmlElements</tt> annnotation can be used with the
 * following program elements: </p>
 * <ul>
 *   <li> a JavaBean property </li>
 *   <li> field </li>
 * </ul>
 *
 * This annotation is intended for annotation a JavaBean collection
 * property (e.g. List). 
 *
 * <p><b>Usage</b></p>
 *
 * <p>The usage is subject to the following constraints:
 * <ul>
 *   <li> type of the JavaBean property must be one of: indexed
 *        property, array, List, java.util.Set.
 *        <br> java.util.Map does not map naturally to XML Schema
 *        construct. Hence <tt>@XmlJavaTypeAdapter</tt> should be used
 *        to customize <tt>java.util.Map</tt>.</li>
 *
 *   <li> This annotation can only be used with the following
 *        annotations: &#64;XmlIDREF. </li>
 *   <li> If @XmlIDREF is also specified on the JavaBean property,
 *        then each &#64;XmlElement.type() must contain a JavaBean
 *        property annotated with <tt>&#64;XmlID</tt>.</li>
 * </ul>
 *
 * <p>See "Package Specification" in javax.xml.bind.package javadoc for
 * additional common information.</p>
 *
 * <hr>
 * 
 * <p><b>Example 1:</b> Map to a list of elements</p>
 * <pre>
 *    
 *    // Mapped code fragment
 *    public class Foo {
 *        &#64;XmlElements(
 *            &#64;XmlElement(name="A", type=Integer.class),
 *            &#64;XmlElement(name="B", type=Float.class)
 *         }
 *         public List items;
 *    }
 *
 *    &lt;!-- XML Representation for a List of {1,2.5} 
 *            XML output is not wrapped using another element -->
 *    ...
 *    <A> 1 </A>
 *    <B> 2.5 </B>
 *    ...
 *
 *    &lt;!-- XML Schema fragment -->
 *    &lt;xs:complexType name="Foo">
 *      &lt;xs:sequence>
 *        &lt;xs:choice minOccurs="0" maxOccurs="unbounded">
 *          &lt;xs:element name="A" type="xs:int"/>
 *          &lt;xs:element name="B" type="xs:float"/>
 *        &lt;xs:choice>
 *      &lt;/xs:sequence>
 *    &lt;/xs:complexType>
 *
 * </pre>
 *
 * <p><b>Example 2:</b> Map to a list of elements wrapped with another element
 * </p>
 * <pre>
 * 
 *    // Mapped code fragment
 *    public class Foo {
 *        &#64;XmlElementWrapper(name="bar")
 *        &#64;XmlElements(
 *            &#64;XmlElement(name="A", type=Integer.class),
 *            &#64;XmlElement(name="B", type=Float.class)
 *        }
 *        public List items;
 *    }
 *
 *    &lt;!-- XML Schema fragment -->
 *    &lt;xs:complexType name="Foo">
 *      &lt;xs:sequence>
 *        &lt;xs:element name="bar">
 *          &lt;xs:complexType>
 *            &lt;xs:choice minOccurs="0" maxOccurs="unbounded">
 *              &lt;xs:element name="A" type="xs:int"/>
 *              &lt;xs:element name="B" type="xs:float"/>
 *            &lt;/xs:choice>
 *          &lt;/xs:complexType>
 *        &lt;/xs:element>
 *      &lt;/xs:sequence>
 *    &lt;/xs:complexType>
 * </pre>
 *
 * @author <ul><li>Kohsuke Kawaguchi, Sun Microsystems, Inc.</li><li>Sekhar Vajjhala, Sun Microsystems, Inc.</li></ul>
 * @see XmlElement 
 * @see XmlElementRef
 * @see XmlElementRefs
 */
@Retention(RUNTIME) @Target({FIELD,METHOD})
public @interface XmlElements {
    /**
     * Collection of @{@link XmlElement} annotations
     */
    XmlElement[] value();
}
