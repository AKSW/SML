Mark all the triples that are generated from the given table using the given view.

<br />
(Please note that the symbol <i>a</i> is a shorthand for <i>rdf:type</i>.)

<div class="navcontainer">
<ul class="navlist">
<li>

<table class="dbtable">
  <tr><th>departments</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Development</td></tr>
</table>

</li>
</ul>
</div>

<br style="clear: both;" />

<textarea style="height: 150px" ui-codemirror="editorOptions.sml" readonly>
Prefix ex: &lt;http://example.com/&gt;

Create View DepartmentsView As
  Construct {
    ?s a ex:Department
  }
  With
    ?s = uri(ex:, ?id)
  From
    departments
</textarea>





<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/1&gt; a ex:Department  .</textarea>
<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/Department&gt; a ex:Department  .</textarea>
<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/1&gt; ex:id 1 .</textarea>
<textarea style="height: 30px" ui-codemirror="editorOptions.ttl" readonly>ex:Department a "1" .</textarea>

