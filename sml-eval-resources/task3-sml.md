Mark all the triples that actually appear as output of the given mappings for the given tables.

<br />
In this task setting, there are departments and employees that work in them:

<div class="navcontainer">
<ul class="navlist">
<li>


<table class="dbtable">
  <tr><th>departments</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Development</td></tr>
</table>

</li>
<li>

<table class="dbtable">
  <tr><th>employees</th></tr>
  <tr><th>id (int)</th><th>name (text)</th><th>department_id</th></tr>
  <tr><td>1</td><td>Susan</td><td>1</td></tr>
</table>

</li>
</ul>
</div>

<br style="clear: both;" />

<textarea style="height: 320px" ui-codemirror="editorOptions.sml" readonly>
Prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>
Prefix ex: <http://example.com/>

Create View Departments As
  Construct {
    ?s a ex:Department .
    ?s rdfs:label ?l
  }
  With
    ?s = uri(ex:, 'department', ?id)
    ?l = plainLiteral(?name)
  From
    departments

Create View EmpsToDepts As
  Construct {
    ?s ex:worksIn ?d
  }
  With
    ?s = uri(ex:, 'employee', ?id)
    ?d = uri(ex:, 'department', ?department_id)
  From
    employees
</textarea>



<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:department1 rdfs:label "Development" .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:employee1 ex:worksIn ex:department1 .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:department1 ex:hasLeader ex:employee1 .</textarea>
<textarea style="height: 20px" ui-codemirror="editorOptions.ttl" readonly>ex:employee1 rdfs:label "Susan" .</textarea>


