Mark all the triples that actually appear as output of the given mapping for the given table.

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

<textarea style="height: 180px" ui-codemirror="editorOptions.sml" readonly>
Prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt;
Prefix ex: &lt;http://example.com/&gt;

Create View Departments As
  Construct {
    ?s a ex:Department .
    ?s rdfs:label ?l
  }
  With
    ?s = uri(ex:, ?id)
    ?l = plainLiteral(?name)
  From
    departments
</textarea>



<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/1&gt; a ex:Department .</textarea>
<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/2&gt; rdfs:label "Design" .</textarea>
<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/Design&gt; rdfs:label "1" .</textarea>
<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/Development&gt; a ex:Department .</textarea>


