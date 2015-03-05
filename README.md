# java-xml-lib

**XML** is one of the most common data exchange formats used between computers.
It is based on the idea that every data can be sub-divided into several *components*,
and that each such data can have a set of associated information or *attributes*.
Let's go through this example to better understand what XML is.

> Consider a computer. Let's say your computer was made by a manufacturer who
> has provided you with warrenty card. The warrenty card  is attached to the
> *product id* of your computer and also contains information like purchase date,
> purchaser name, and some other details. All of these details can be considered
> as the *attributes* of your computer, that describe it.

> Again this computer is made up of is made up of a few parts, namely, CPU,
> monitor, speaker, keyboard and mouse. These are the *components* of your
> computer. Note that each of these components have their own product ids'
> and specifications, i.e., their own *attributes*. This is how the structure
> of XML is.


## Examples

## Reference

| `class Xml` |   |
|-------------|---|
| **Xml** <br/> `(file)`, `(str)`                                                                                            | parse an xml file or string <br/>                                                                                          `Xml xml = new Xml(new File("students.xml"));` <br/>                                                                       `Xml xml = new Xml("<movie name="Xmlon"/>");` |
| **equals** <br/> `(xml)`                                                                                                   | check if 2 xml elements are equal (content) <br/>                                                                          `boolean equals = xml1.equals(xml2);` | 
