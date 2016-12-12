<!DOCTYPE html>
<html>
<head>
    <#include "header.ftl">
</head>

<body>
    <main>
        <#list shows as show>
            <h1>${show.title}</h1>
            <p>
            Welcome to Sour Boat Life, a show where Brian and Daniel get together, write some software, hang out, and
            generally dick around!
            </p>
            <p>
            This show started off based purely on our desire to hang out more often now that we live in different states.
            I thought, "Hey! You know what sounds like fun? Writing whatever the heck we feel like instead of the boring
            old crap we have to write for a living!" And so here we are.
            </p>
            <p>
            We have both been professional software engineers for 10+ years each now and have developed quite a bit of
            knowledge about software and best practices and even MORE strong unsubstantiated <i>opinions</i> about it
            and everything else. Please, allow us to entertain you with our banter and share with you all of our grand
            ideals about software development!
            </p>
            <#list show.episodes as episode>
                <article class="episode">
                    <details <#if episode?counter == 1>open</#if>>
                        <summary>
                            <h2>${episode.title?html}</h2>
                            <span class="airdate">${episode.originalAirDate}</span>
                            <p class="show-description">${episode.description}</p>
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