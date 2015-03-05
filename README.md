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
| **same** <br/> `(xml)`                                                                                                     | check if 2 xml elements are same (content & reference) <br/>                                                               `boolean same = xml.same(xml2);` |
| **document** <br/> `()`                                                                                                    | get the W3C document object <br/>                                                                                         `Document doc = xml.document();` |
| **element** <br/> `()`                                                                                                     | get current W3C element <br/>                                                                                            `Element elem = xml.element();` |
| **root** <br/> `()`                                                                                                        | get the root element <br/>                                                                                                 `Xml root = xml.root();` |
| **parent** <br/> `()`, `(name)`                                                                                            | get parent element (opt. with given name) <br/>                                                                           `Xml parent = xml.parent();` <br/>                                                                                          `Xml hulk = xml.parent("hulk");` |
| **prev** <br/> `()`, `(name)`                                                                                              | get previous element (opt. with given name) <br/>                                                                          `Xml prev = xml.prev();` <br/>                                                                                               `Xml mojo = xml.prev("mojo");` |
| **next** <br/> `()`, `(name)`                                                                                              | get next element (opt. with given name) <br/>                                                                             `Xml next = xml.next();` <br/>                                                                                               `Xml bojo = xml.next("bojo");` |
| **child** <br/> `()`, `(name)`                                                                                             | get first child element (opt. with given name) <br/>                                                                       `Xml child = xml.child();` <br/>                                                                                            `Xml bear = xml.child("bear");` |
| **lastChild** <br/> `()`, `(name)`                                                                                         | get last child element (opt. with given name) <br/>                                                                       `Xml lastChild = xml.lastChild();` <br/>                                                                                     `Xml beaver = xml.lastChild("beaver");` |
| **children** <br/> `()`, `(name)`                                                                                          | get children elements (opt. with given name) <br/>                                                                       `List<Xml> children = xml.children();` <br/>                                                                                `List<Xml> ducks = xml.children("ducks");` |
| **elem** <br/> `(name)`                                                                                                    | create new element with given name <br/>                                                                                  `Xml ark = xml.elem("ark");` |
| **copy** <br/> `()`                                                                                                        | copy current element to be used elsewhere <br/>                                                                            `Xml copy = xml.copy();` |
| **addPrev** <br/> `(xml)`, `(name)`                                                                                        | adds new element before current (returns new) <br/>                                                                       `Xml actor = xml.addPrev(actorXml);` <br/>                                                                                   `Xml sensor = xml.addPrev("sensor");` |
| **addNext** <br/> `(xml)`, `(name)`                                                                                        | adds new element after current (returns new) <br/>                                                                       `Xml nuclear = xml.addNext(nuclearXml);` <br/>                                                                              `Xml fuel = xml.addNext("fuel");` |
| **add** <br/> `(xml)`, `(name)`                                                                                            | adds new element as child (returns new) <br/>                                                                             `Xml cocoa = xml.add(cocoaXml);` <br/>                                                                                      `Xml seed = xml.add("seed");` |
| **remove** <br/> `()`                                                                                                      | removes current element (returns parent) <br/>                                                                             `Xml parent = xml.remove();` |
| **save** <br/> `(file)`                                                                                                    | saves current element to file <br/>                                                                                        `xml.save(new File("weapons.xml"));` |
