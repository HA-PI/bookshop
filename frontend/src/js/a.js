(function() {
  var bitlist, jq, kids, singers, song;

  jq = require('jquery');

  song = ["do", "re", "mi", "fa", "so"];

  singers = {
    Jagger: "Rock",
    Elvis: "Roll"
  };

  bitlist = [1, 0, 1, 0, 0, 2, 1, 1, 0];

  kids = {
    brother: {
      name: "Max",
      age: 11
    },
    sister: {
      name: "Ida",
      age: 9
    }
  };

  console.log(jq, song, singers, bitlist, kids);

}).call(this);

//# sourceMappingURL=a.js.map
