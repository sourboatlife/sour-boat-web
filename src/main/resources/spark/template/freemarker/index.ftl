<!DOCTYPE html>
<html>
<head>
    <#include "header.ftl">
</head>

<body>
    <main>
        <#list shows as show>
            <h1>${show.title}</h1>
            <#list show.episodes as episode>
                <article class="episode">
                    <details <#if episode?counter == 1>open</#if>>
                        <summary>
                            <h2>${episode.title?html}</h2>
                            <span class="airdate">${episode.originalAirDate}</span>
                            <p>${episode.description}</p>
                        </summary>
                        <ul class="parts"
                            <#list episode.links as url>
                                <li><iframe width="560" height="315" src="${url}" frameborder="0" allowfullscreen></iframe></li>
                            </#list>
                        </ul>
                        <footer><#list episode.tags as tag><span>${tag}</span></#list></footer>
                    </details>
                </article>
            </#list>
        </#list>
    </main>
</body>
</html>