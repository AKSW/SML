Mark the views whose combination yields <b>exactly</b> the given reference output based on the given table. Exactly means, that a mapping process using these inputs may yield neither excessive nor missing triples when compared to the given reference output.

<table class="table table-striped">
  <thead>
    <tr><th>department</th></tr>
    <tr><th>id (int)</th></tr><tr><th>name (text)</th></tr>
  </thead>
  <tbody>
  <tr><td>1</td><td>Development</td></tr>
  <tr><td>2</td><td>Design</td></tr>
 </tbody>
</table>

Thereby assume the following prefixes
<textarea style="height: 70px" ui-codemirror="editorOptions.sml">
Prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt;

Prefix o: &lt;http://example.com/ontology/&gt;
Prefix r: &lt;http://example.com/resource/&gt;
</textarea>

<textarea style="height: 90px" ui-codemirror="editorOptions.ttl">
r:Development
  a o:Department ;
  o:id "1"^^xsd:integer ;
  rdfs:label "Department" .

r:Design
  a o:Department ;
  o:id "2"^^xsd:integer ;
  rdfs:label "Development" .
</textarea>


<textarea style="height: 200px" ui-codemirror="editorOptions.sml">
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

<textarea style="height: 200px" ui-codemirror="editorOptions.sml">
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

<textarea style="height: 200px" ui-codemirror="editorOptions.sml">
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




<textarea style="height: 250px" ui-codemirror="editorOptions.ttl">

</textarea>






<h2>Mark all the triples that generated from the given table by the mapping</h2>

<table class="table table-striped">
  <thead>
    <tr><th>departments</th></tr>
    <tr><th>id (int)</th></tr><tr><th>name (text)</th></tr>
  </thead>
  <tbody>
  <tr><td>1</td><td>Development</td></tr>
  </tbody>
</table>

<textarea style="height: 250px" ui-codemirror="editorOptions.ttl">
Prefix ex: &lt;http://example.com/&gt;
Prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt;

Create View TriplesMap1 As
  Construct {
    ?s
      a ex:Department ;
      rdfs:label ?l
  }
  With
    ?s = uri(ex:, ?id)
    ?l = plainLiteral(?name)
  From
    departments
</textarea>





