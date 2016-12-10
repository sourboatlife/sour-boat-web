<!DOCTYPE html>
<html>
<head>
    <#include "header.ftl">
</head>

<body>
    <main>
        <h1>Sour Boat Life</h1>
        <#list show.episodes as episode>
            <article class="episode">
                <details>
                    <summary>
                        <h2>${episode.originalAirDate}: ${episode.title?html}</h2>
                    </summary>
                    <p>${episode.description}</p>
                    <ul class="parts">
                        <#list episode.links as url>
                            <li><iframe width="560" height="315" src="${url}" frameborder="0" allowfullscreen></iframe></li>
                        </#list>
                    </ul>
                    <footer><#list episode.tags as tag><span>${tag}</span></#list></footer>
                </details>
            </article>
        </#list>
    </main>
</body>
</html>