Stanford NLP Service
====================

This is a wrapper for Python2 and Java of the Stanford NLP library, particulary the Named Entity Recognition Function.

Installation
------------

To install, you must first have installed Apache Thrift (https://thrift.apache.org/download) and Gradle. Both executables (thrift and gradle) should be in the PATH at the moment of compilation. The installation procedure is as follows:
* `git clone https://github.com/ptorrestr/StanfordCoreNLPService`
* `gradle` (compile)

The compilation will generate a jar file (./build/libs/) and a python module (./build/python/).

Execution
---------

To execute the server, you must execute the following command: `java -jar StanfordCoreNLPService-*.jar [port] [conf]` where port is the port of localhost where the server is going to hear for incoming connetions and conf is argument not used yet.

The python module can be installed as the normal way: `python setup.py install`. The file ./build/python/corenlp/StanfordCoreNLPService-remote is an example of client.

