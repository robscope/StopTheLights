var lightStates = {red:0,amber:1,green:2};
var currentState = lightStates.red;

interval = "";

function run()
{
  document.getElementById("red").className ="light red";
  if(interval == "")
  {
    interval = setInterval(function(){
    changeState();
    }, 2000);
  }
  else
  {
    clear();
    currentState = lightStates.red;
      interval = clearInterval();
  }
}

function changeState()
{
  clear();
  switch(currentState)
  {
    case lightStates.red:
    {
      document.getElementById("red").className ="light red";
      document.getElementById("amber").className ="light off";
      document.getElementById("green").className ="light off";
      currentState =  lightStates.amber;
    }
    break;
    case lightStates.amber:
    {
      document.getElementById("red").className ="light off";
      document.getElementById("amber").className ="light amber";
    document.getElementById("green").className ="light off";
      currentState = lightStates.green;
    } break;
     case lightStates.green:
    {
      document.getElementById("red").className ="light off";
    document.getElementById("amber").className ="light off";
      document.getElementById("green").className ="light green";
      currentState = lightStates.red;
    } break;
   }
}

function clear(){
   document.getElementById("red").className ="light off";
   document.getElementById("amber").className ="light off";
   document.getElementById("green").className ="light off";
}