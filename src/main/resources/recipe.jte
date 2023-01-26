@import com.github.professorSam.strawberriesAndPotatoes.recipe.Recipe;

@param Recipe recipe

<header>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="${recipe.getShortDescription()}">
    <title>${recipe.getTitle()}</title>
</header>
<body>
<div class="content">
    <div class="title">
        <h1>${recipe.getTitle()}</h1>
    </div>
    <div class="shortDescription">
        <p>${recipe.getShortDescription()}</p>
    </div>
    <div class="ingredients">
        <h3>Zutaten:</h3>
        <ul>
            @for(String str : recipe.getIngredients())
                <li>${str}</li>
            @endfor
        </ul>
    </div>
    <div class="utensils">
        <h3>Utensilien:</h3>
        <ul>
            @for(String str : recipe.getUtensils())
                <li>${str}</li>
            @endfor
        </ul>
    </div>
    <div class="longDescription">
        <h3>Zubereitug:</h3>
        <p>${recipe.getLongDescription()}</p>
    </div>
</div>
</body>
<style>
    body {
        background-color: #688fff;
        font-family: Tahoma, serif;
    }

    .content {
        margin: 10%;
        box-shadow: 0 0 1px #ffffff;
        padding: 15px;
        background-color: #ff4a50;
    }

    .title h1 {
        font-weight: bold;
        text-align: center;
        color: #cecece;
    }

    .title {
        border-bottom: 3px solid #ffffff;
        padding-bottom: 10px;
        margin-left: 20%;
        margin-right: 20%;
    }

    .shortDescription {
        font-style: italic;
        text-align: center;
        color: #afaaab;
    }

    .ingredients ul, .utensils ul {
        text-align: left;
        color: #ffffff;
    }

    .longDescription p {
        color: #ffffff;
    }

    h3 {
        font-weight: bold;
        text-align: center;
        color: #cecece;
    }
</style>
