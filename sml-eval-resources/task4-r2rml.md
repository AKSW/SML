Mark the view that <i>exactly</i> yields the given reference output based on the given table.

<div class="navcontainer">
<ul class="navlist">
<li>

<table class="dbtable">
  <tr><th>employees</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Susan</td></tr>
  <tr><td>2</td><td>John</td></tr>
</table>

</li>
</ul>
</div>

<br style="clear: both;" />

Reference Output (assume the prefixes hold for the whole task):
<textarea style="height: 220px" ui-codemirror="editorOptions.ttl" readonly>
@prefix xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt; .
@prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .

@prefix o: &lt;http://example.com/ontology/&gt; .
@prefix r: &lt;http://example.com/resource/&gt; .


r:Susan
  a o:Employee ;
  rdfs:label "Susan" ;
  o:id "1"^^xsd:integer .

r:John
  a o:Employee ;
  rdfs:label "John" ;
  o:id "2"^^xsd:integer .
</textarea>




<textarea style="height: 290px" ui-codemirror="editorOptions.ttl" readonly>
&lt;EmployeesMap1&gt;&#13;&#10;
  a rr:TriplesMap;&#13;&#10;
  rr:logicalTable [ rr:tableName "employees" ] ;&#13;&#10;
  rr:subjectMap [&#13;&#10;
    rr:template "http://example.com/resource/\{name\}"&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate rdf:type ;&#13;&#10;
    rr:object ex:Employee&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate rdfs:label ;&#13;&#10;
    rr:objectMap [ rr:column "name" ]&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate o:id ;&#13;&#10;
    rr:objectMap [&#13;&#10;
      rr:column "id" ;&#13;&#10;
      rr:datatype xsd:integer &#13;&#10;
    ]&#13;&#10;
  ] .
</textarea>



<textarea style="height: 330px" ui-codemirror="editorOptions.ttl" readonly>
&lt;EmployeesMap2&gt;&#13;&#10;
  a rr:TriplesMap;&#13;&#10;
  rr:logicalTable [ rr:tableName "employees" ] ;&#13;&#10;
  rr:subjectMap [&#13;&#10;
    rr:template "http://example.com/resource/\{name\}"&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate rdf:type ;&#13;&#10;
    rr:object ex:Employee&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate rdfs:label ;&#13;&#10;
    rr:objectMap [&#13;&#10;
      rr:column "name" ;&#13;&#10;
      rr:language "en"&#13;&#10;
    ]&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate o:id ;&#13;&#10;
    rr:objectMap [&#13;&#10;
      rr:column "id" ;&#13;&#10;
      rr:datatype xsd:integer &#13;&#10;
    ]&#13;&#10;
  ] .
</textarea>



<textarea style="height: 290px" ui-codemirror="editorOptions.ttl" readonly>
&lt;EmployeesMap3&gt;&#13;&#10;
  a rr:TriplesMap;&#13;&#10;
  rr:logicalTable [ rr:tableName "employees" ] ;&#13;&#10;
  rr:subjectMap [&#13;&#10;
    rr:template "http://example.com/resource/\{name\}"&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate rdf:type ;&#13;&#10;
    rr:object ex:Employee&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate rdfs:label ;&#13;&#10;
    rr:objectMap [ rr:column "name" ]&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate o:id ;&#13;&#10;
    rr:objectMap [&#13;&#10;
      rr:template "id"&#13;&#10;
    ]&#13;&#10;
  ] .
</textarea>

