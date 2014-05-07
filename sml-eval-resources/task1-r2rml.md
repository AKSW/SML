Mark all the triples that are generated from the given table using the given view.

<br />
(Please note that the symbol <i>a</i> is a shorthand for <i>rdf:type</i>.)

<div class="navcontainer">
<ul class="navlist">
<li>

<table class="dbtable">
  <tr><th>employees</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Susan</td></tr>
</table>

</li>
</ul>
</div>

<br style="clear: both;" />

<textarea style="height: 200px" ui-codemirror="editorOptions.ttl" readonly>
@prefix rr: &lt;http://www.w3.org/ns/r2rml#&gt; .
@prefix rdf: &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix ex: &lt;http://example.com/&gt; .

&lt;EmployeesMap&gt;
  a rr:TriplesMap ;
  rr:logicalTable [ rr:tableName "employees" ] ;
  rr:subjectMap [
    rr:template "http://example.com/\{id\}"
  ] ;
  rr:predicateObjectMap [
    rr:predicate rdf:type ;
    rr:object ex:Employee
  ] .
</textarea>


<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/1&gt; a ex:Employee .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/Susan&gt; a ex:Employee .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>&lt;http://example.com/1&gt; ex:id 1 .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:Employee a "1" .</textarea>

