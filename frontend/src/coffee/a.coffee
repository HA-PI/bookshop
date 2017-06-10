$ = require 'jquery'
{alert, confirm} = require 'dialog'

song = ["do", "re", "mi", "fa", "so"]

singers = {Jagger: "Rock", Elvis: "Roll"}

text = "Every literary critic believes he will
        outwit history and have the last word"

text = """
       Every literary critic believes he will
         outwit history and have the last word
       """
time_gen = =>
  "The time is #{new Date().toLocaleTimeString()}"

time = ->
    "The time is #{new Date().toLocaleTimeString()}"



bitlist = [
  1, 0, 1
  0, 0, 1
  1, 1, 1
]

kids =
  brother:
    name: "Max"
    age: 11
  sister:
    name: "Ida"
    age: 9

console.log alert, confirm, song, singers, bitlist, kids

class Person
  constructor: (@firstName, @lastName) ->

  name: ->
    "#{@first_name} #{@last_name}"

  setName: (name) ->
    names = name.split " "

    @firstName = names[0]
    @lastName = names[1]

blake = new Person "Blake", "Williams"
blake.setName("Blake Anderson")
console.log blake.name()

alert "content", "title"


