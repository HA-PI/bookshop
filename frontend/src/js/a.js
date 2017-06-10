var Person, bitlist, blake, kids, singers, song;

import jq from 'jquery';

import {alert, confirm} from 'dialog';

song = ["do", "re", "mi", "fa", "so"];

singers = {
  Jagger: "Rock",
  Elvis: "Roll"
};

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

console.log(jq, alert, confirm, song, singers, bitlist, kids);

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

$("button").on("click", function() {
  return alert($(this).id());
});

//# sourceMappingURL=a.js.map
