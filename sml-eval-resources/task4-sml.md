Mark the view that <i>exactly</i> yields the given reference output based on the given table.

<div class="navcontainer">
<ul class="navlist">
<li>

<table class="dbtable">
  <tr><th>departments</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Development</td></tr>
  <tr><td>2</td><td>Design</td></tr>
</table>

</li>
</ul>
</div>

<br style="clear: both;" />

Reference Output (assume the prefixes hold for the whole task):
<textarea style="height: 220px" ui-codemirror="editorOptions.ttl" readonly>
Prefix xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt;
Prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt;

Prefix o: &lt;http://example.com/ontology/&gt;
Prefix r: &lt;http://example.com/resource/&gt;


r:Development
  a o:Department ;
  rdfs:label "Development" ;
  o:id "1"^^xsd:integer .

r:Design
  a o:Department ;
  rdfs:label "Design" ;
  o:id "2"^^xsd:integer .
</textarea>




<textarea style="height: 200px" ui-codemirror="editorOptions.sml" readonly>
Create View DepartmentsView1 As&#13;&#10;
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
Create View DepartmentsView2 As&#13;&#10;
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
Create View DepartmentsView3 As&#13;&#10;
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

