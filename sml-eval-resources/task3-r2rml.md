Mark all the triples that actually appear as output of the given mappings for the given tables.

<br />
In this task setting, there are departments and employees that work in them:

<div class="navcontainer">
<ul class="navlist">
<li>


<table class="dbtable">
  <tr><th>employees</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Susan</td></tr>
</table>

</li>
<li>

<table class="dbtable">
  <tr><th>departments</th></tr>
  <tr><th>id (int)</th><th>name (text)</th><th>employee_id</th></tr>
  <tr><td>1</td><td>Development</td><td>1</td></tr>
</table>

</li>
</ul>
</div>

<br style="clear: both;" />

<textarea style="height: 380px" ui-codemirror="editorOptions.ttl" readonly>
@prefix rr: &lt;http://www.w3.org/ns/r2rml#&gt; .
@prefix rdf: &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix ex: &lt;http://example.com/&gt; .

&lt;EmployeesMap&gt;
  a rr:TriplesMap ;
  rr:logicalTable [ rr:tableName "employees" ] ;
  rr:subjectMap [
    rr:template "http://example.com/employee\{id\}"
  ] ;
  rr:predicateObjectMap [
    rr:predicate rdf:type ;
    rr:object ex:Employee
  ] ;
  rr:predicateObjectMap [
    rr:predicate rdfs:label ;
    rr:objectMap [ rr:column "name" ]
  ] .

&lt;DeptToEmpOtm&gt;
  a rr:TriplesMap ;
  rr:logicalTable [ rr:tableName "departments" ] ;
  rr:subjectMap [
    rr:template "http://example.com/department\{id\}" ;
  ] ;
  rr:predicateObjectMap [
    rr:predicate ex:hasLeader ;
    rr:objectMap [ rr:template "http://example.com/employee\{employee_id\}" ]
  ] .
</textarea>



<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:employee1 rdfs:label "Susan" .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:department1 ex:hasLeader ex:employee1 .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:exployee1 ex:worksIn ex:department1 .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:department1 rdfs:label "Development" .</textarea>


