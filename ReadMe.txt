Albero Management console
=========================

Can be used to administer Albero trees in the database. It is a very simple JEE application and requires a Java EE Application server and the Albero database to run.

---------------
Installation
---------------
The console expects a JNDI datasource 'MySqlDS' pointing to the 'tree' table of the albero database.

---------------
Usage
---------------
To generate the ear file type 'mvn install' on the command line (supposing you have maven installed). Deploy the ear file on your application server.
	
---------------
License
---------------

Albero is licensed under the Apache License, Version 2.0. You can find the
terms and conditions for use, reproduction, and distribution of Albero in the
LICENSE file in the distribution or at
http://www.apache.org/licenses/LICENSE-2.0.
