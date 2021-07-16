const easy = [
    "6------7------5-2------1---362----81--96-----71--9-4-5-2---651---78----345-------",
    "685329174971485326234761859362574981549618732718293465823946517197852643456137298"
  ];
  const medium = [
    "--9-------4----6-758-31----15--4-36-------4-8----9-------75----3-------1--2--3--",
    "619472583243985617587316924158247369926531478734698152891754236365829741472163895"
  ];
  const hard = [
    "-1-5-------97-42----5----7-5---3---7-6--2-41---8--5---1-4------2-3-----9-7----8--",
    "712583694639714258845269173521436987367928415498175326184697532253841769976352841"
  ];


var timer;
var timeRemain;
var lives;
var selectedNum;
var selectedTile;
var disableSelect;

function id(id){
    return document.getElementById(id);
}

window.onload = function(){
    id("newGame").addEventListener("click", startGame);
}

function startGame(){
    // set difficulty
    if(id("easyDiff").checked) board = easy[0];
    else if(id("midDiff").checked) board = medium[0];
    else board = hard[0];

    // set lives and selecting number tiles
    lives = 3;
    disableSelect = false;
    id("lives").textContent = `Lives Remaining: ${lives}`;

    // generates board based on difficulty
    generateBoard(board);
}

function generateBoard(board){
    // clear previous board
}

