<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center">
  <div class="container">
    <h1>Sour Boat Life</h1>
  </div>
</div>

<div class="container">
    <#list show.episodes as episode>
        <div class="panel panel-default">
          <div class="panel-body">
            ${episode.title?html}
          </div>
        </div>
    </#list>
</div>

</body>
</html>