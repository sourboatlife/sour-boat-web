<!DOCTYPE html>
<html>
<head>
    <title>Sour Boat Life Enhanced Terminal Magic</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/sh.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/stylesheets/sh.css"/>
</head>

<body>
    <main class="sh">
        <form method="POST" onsubmit="return false;" action="sh">
        <pre class="terminal output"></pre>
        <label for="cmd" id="prompt"></label><input type="text" name="cmd" id="cmd">
        </form>
    </main>

    <!--

    <div title="SourBoatLife">
        <div title="Episode 1">
            <div title="title">
            <div title="description">
            <div title="tags">
            <div title="videos">
                <div title="Part 1">
                    <iframe...
                <div title="Part 2">
                    <iframe...

    -->

    <div id="data" style="display:none">
      <#list shows as show>
        <div title="SourBoatLife">
          <#list show.episodes as episode>
            <div title="Episode_${episode?counter}" data-airdate="${episode.originalAirDate}">
              <div title="title">${episode.title?html}</div>
              <div title="description">${episode.description}</div>
              <div title="tags"><#list episode.tags as tag>${tag} </#list></div>
              <div title="videos">
                <#list episode.links as url>
                  <div title="part ${url?counter}">
                    <iframe width="560" height="315" src="${url}" frameborder="0" allowfullscreen>
                    </iframe>
                  </div>
                </#list>
              </div>
              </div>
          </#list>
        </div>
      </#list>
    </div>
</body>
</html>