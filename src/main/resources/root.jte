<head>
    <title>Erdbeeren und Kartoffeln</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="Rezepte mit Kartoffeln und Erdbeeren">
</head>
<body>
<div class="header">
    <h1>Random Rezept</h1>
</div>
<div class="button">
    <button onclick="location.href = '/random';">🚀</button>
</div>
<div class="footer">
    <h2>mit Erdbeeren und Kartoffeln 🍓🥔</h2>
</div>
</body>
<style>
    body {
        overflow: hidden;
        margin: 0;
        height: 100%;
        background-color: #688fff;
    }

    .button {
        width: 100%;
        height: calc(100% / 3);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    button {
        background-color: #ff4a50;
        border: none;
        color: white;
        padding: 70px 70px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 40px;
        border-radius: 50%;
        box-shadow: -1px 10px #942a2a;
        transition: box-shadow 0.5s;
    }

    button:hover {
        box-shadow: -1px 10px #651c1c;
    }

    button:active {
        transition: none;
        box-shadow: none;
        padding: 50px 50px 50px;
    }

    .header {
        display: flex;
        justify-content: center;
        align-items: center;
        text-align: center;
        width: 100%;
        height: calc(100% / 3);
    }

    .header h1{
        color: white;
        font-size: 50px;
        font-family: Tahoma, serif;
        font-weight: bold;
    }
    .footer {
        display: flex;
        justify-content: center;
        align-items: center;
        text-align: center;
        width: 100%;
        height: calc(100% / 3);
    }

    .footer h2 {
        color: white;
        font-size: 35px;
        font-family: Tahoma, serif;
        font-weight: bold;
    }
</style>