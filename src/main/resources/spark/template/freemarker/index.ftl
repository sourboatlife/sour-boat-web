<!DOCTYPE html>
<html>
<head>
    <#include "header.ftl">
</head>

<body>
    <main>
        <#list shows as show>
            <h1>${show.title}</h1>
            <article>
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
            </article>
            <#list show.episodes as episode>
                <article class="episode" data-tags="<#list episode.tags as tag>${tag} </#list>">
                    <details <#if episode?counter == 1>open</#if>>
                        <summary>
                            <h2>${episode.title?html}</h2>
                            <span class="airdate">${episode.originalAirDate}</span>
                            <p class="show-description">${episode.description}</p>
                        </summary>
                        <ul class="parts">
                            <#list episode.links as url>
                              <#if episode?counter == 1>
                                <li><iframe src="${url}" frameborder="0" allowfullscreen="true" scrolling="no" height="378" width="620"></iframe></li>
                              <#else>
                                <li class="unloaded" data-source="${url}"></li>
                              </#if>
                            </#list>
                        </ul>
                        <footer><#list episode.tags as tag><span>${tag}</span></#list></footer>
                    </details>
                </article>
            </#list>
        </#list>
    </main>
    <script type="text/javascript">
      $("details").on("click", function (e) {
        $(e.currentTarget).find("li.unloaded").each(function(idx, value) {
          var li = $(value);
          var url = li.data("source");
          li.append('<iframe src="' + url + '" frameborder="0" allowfullscreen="true" scrolling="no" height="378" width="620"></iframe>');
          li.removeClass("unloaded");
        });
      });
    </script>
</body>
</html>