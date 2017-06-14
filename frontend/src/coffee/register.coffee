$ = require 'jquery'
{alert, confirm} = require 'dialog'
jq_form = require 'jquery-form';
form = jq_form(document)('#form')

form.ajaxForm(
  beforeSubmit: (data, from, options) ->
    if data.find((a)-> a.name is 'password').value isnt data.find((a) -> a.name is 'pwd-again').value
      alert '两次密码不正确'
      return false
    form.find('[type=submit]').prop('disabled', true);
  success: (json, statusText, xhr, $form) ->
    form.find('[type=submit]').prop('disabled', false);
    alert json.data
  fail: (responseText, statusText, xhr, $form) ->
    console.log responseText, statusText, xhr, $form
  dataType: 'json'
);