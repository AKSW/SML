Mark the views whose combination yields <b>exactly</b> the given reference output based on the given table. Exactly means, that a mapping process using these inputs may yield neither excessive nor missing triples when compared to the given reference output.

<table class="dbtable">
  <tr><th>employees</th></tr>
  <tr><th>id (int)</th></tr><tr><th>name (text)</th></tr>
  <tr><td>1</td><td>Susan</td></tr>
  <tr><td>2</td><td>John</td></tr>
</table>

Thereby assume the following prefixes
<textarea style="height: 70px" ui-codemirror="editorOptions.sml" readonly>
@prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .

@prefix o: &lt;http://example.com/ontology/&gt; .
@prefix r: &lt;http://example.com/resource/&gt; .
</textarea>

<textarea style="height: 90px" ui-codemirror="editorOptions.ttl" readonly>
r:Susan
  a o:Employee ;
  o:id "1"^^xsd:integer ;
  rdfs:label "Susan" .

r:John
  a o:Employee ;
  o:id "2"^^xsd:integer ;
  rdfs:label "John" .
</textarea>


<textarea style="height: 200px" ui-codemirror="editorOptions.sml" readonly>
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix ex: <http://example.com/> .

<TriplesMap1>
  a rr:TriplesMap;
  rr:logicalTable [ rr:tableName "employees" ] ;
  rr:subjectMap [
    rr:template "http://example.com/\{name\}" ;
  ] ;
  rr:predicateObjectMap [
    rr:predicate rdf:type ;
    rr:
  ] ;

Create View MyView1 As&#13;&#10;
  Construct {&#13;&#10;
    ?s&#13;&#10;
      a o:Department ;&#13;&#10;
      rdfs:label ?l ;&#13;&#10;
      o:id ?i&#13;&#10;
  }&#13;&#10;
  With&#13;&#10;
    ?s = uri(r:, ?name)&#13;&#10;
    ?l = plainLiteral(?name)&#13;&#10;
    ?i = typedLiteral(?id, xsd:integer)&#13;&#10;
  From&#13;&#10;
    departments&#13;&#10;
</textarea>

<textarea style="height: 200px" ui-codemirror="editorOptions.sml" readonly>
Create View MyView2 As&#13;&#10;
  Construct {&#13;&#10;
    ?s&#13;&#10;
      a o:Department ;&#13;&#10;
      rdfs:label ?l ;&#13;&#10;
      o:id ?i&#13;&#10;
  }&#13;&#10;
  With&#13;&#10;
    ?s = uri(r:, ?name)&#13;&#10;
    ?l = plainLiteral(?name, 'en')&#13;&#10;
    ?i = typedLiteral(?id, xsd:integer)&#13;&#10;
  From&#13;&#10;
    departments&#13;&#10;
</textarea>

<textarea style="height: 200px" ui-codemirror="editorOptions.sml" readonly>
Create View MyView2 As&#13;&#10;
  Construct {&#13;&#10;
    ?s&#13;&#10;
      a o:Department ;&#13;&#10;
      rdfs:label ?l ;&#13;&#10;
      o:id ?i&#13;&#10;
  }&#13;&#10;
  With&#13;&#10;
    ?s = uri(r:, ?name)&#13;&#10;
    ?l = plainLiteral(?name)&#13;&#10;
    ?i = uri(?id)&#13;&#10;
  From&#13;&#10;
    departments&#13;&#10;
</textarea>

