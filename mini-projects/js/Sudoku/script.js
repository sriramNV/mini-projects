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

// helper functions
function id(id){
    return document.getElementById(id);
}

function qs(selector){
    return document.querySelector(selector);
}

function qsa(selector){
    return document.querySelectorAll(selector);
}

// helper functions ends

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

    startTimer();

    if(id("theme-1").checked){
        qs("body").classList.remove("dark");
    }
    else{
        qs("body").classList.add("dark");
    }

    id("numContainer").classList.remove("hidden");
}


function startTimer(){
    if(id("time-1").checked) timeRemain = 180;
    else if(id("time-2").checked) timeRemain = 300;
    else timeRemain = 600;

    id("timer").textContent = timeConversion(timeRemain);
    timer = setInterval(function(){
        timeRemain--;
        if(timeRemain === 0) endGame();
        id("timer").textContent = timeConversion(timeRemain);
    }, 1000);
}

function timeConversion(timeInSec){
    // convert seconds into string of MM:SS format
    let min = Math.floor(timeInSec / 60);
    if(min < 10) min = "0" + min;
    let sec = timeInSec % 60;
    if(sec < 10) sec = "0" + sec;
    return min + ":" + sec;
}

function generateBoard(board){
    // clear previous board
    clearPrevious();

    let idCount = 0;

    for(let i = 0; i < 81; i++){
        let tile = document.createElement("p");
        if(board.charAt(i) != '-'){
            tile.textContent = board.charAt(i);
        }else{
            // add click event to tile
        }
        tile.id = idCount;
        idCount++;

        tile.classList.add("tile");
        if((tile.id > 17 && tile.id < 27) || (tile.id > 44 && tile.id < 54)){
            tile.classList.add("bottomBorder");
        }
        if((tile.id+1) % 9 == 3 || (tile.id +1) % 9 == 6){
            tile.classList.add("rightBorder");
        }

        id("board").appendChild(tile);
    }
}

function clearPrevious(){
    let tiles = qsa(".tile");

    for(let i = 0; i < tiles.length; i++){
        tiles[i].remove();
    }

    if(timer) clearTimeout(timer);

    for(let i = 0 ; i < id("numContainer").children.length; i++){
        id("numContainer").children[i].classList.remove("selected");
    }

    selectedTile = null;
    selectedNum = null;

}



