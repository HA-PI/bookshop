(function() {
  var $, Person, alert, bitlist, blake, confirm, kids, ref, singers, song, text, time, time_gen;

  $ = require('jquery');

  ref = require('dialog'), alert = ref.alert, confirm = ref.confirm;

  song = ["do", "re", "mi", "fa", "so"];

  singers = {
    Jagger: "Rock",
    Elvis: "Roll"
  };

  text = "Every literary critic believes he will outwit history and have the last word";

  text = "Every literary critic believes he will\n  outwit history and have the last word";

  time_gen = (function(_this) {
    return function() {
      return "The time is " + (new Date().toLocaleTimeString());
    };
  })(this);

  time = function() {
    return "The time is " + (new Date().toLocaleTimeString());
  };

  new Promise(function(resolve, reject) {
    return resolve(120);
  });

  bitlist = [1, 0, 1, 0, 0, 1, 1, 1, 1];

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

  Person = (function() {
    function Person(firstName, lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    Person.prototype.name = function() {
      return this.first_name + " " + this.last_name;
    };

    Person.prototype.setName = function(name) {
      var names;
      names = name.split(" ");
      this.firstName = names[0];
      return this.lastName = names[1];
    };

    return Person;

  })();

  blake = new Person("Blake", "Williams");

  blake.setName("Blake Anderson");

  console.log(blake.name());

}).call(this);
