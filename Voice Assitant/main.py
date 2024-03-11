from os import system
import speech_recognition as sr
from playsound import playsound
from gpt4all import GPT4All
import sys
import whisper
import warnings
import time
import os
import pyttsx3
wake_word = "jarvis"
model = GPT4All("C:\Users\adity\AppData\Local\nomic.ai\GPT4All\ggml-model-gpt4all-falcon-q4_0.bin")
r =sr.Recognizer()
tiny_model = whisper.load_model('tiny')
base_model = whisper.load_model('base')
listening_for_wake_word = True
source = sr.Microphone()
engine = pyttsx3.init()

def speak(text):
    if sys.platform == 'darwin':
        ALLOWED_CHARS = set("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?,.-_$:+-/ ")
        clean_text = ''.join(c for c in text if c in ALLOWED_CHARS)
        system(f'say {clean_text}')
    else:
        engine.say(text)
        engine.runAndWait()

def listen_for_wake_word():
    global listen_for_wake_word
    with open("wake_word.txt", "w") as f:
        f.write(audio.get_wav_data())
    result = tiny_model.transcribe('wave_detect.wav')
    text_input = result['text']
    if wake_word in text_input.lower().strip():
        print("Wake word detected. Please speak your command.")
        speak('Listening')
        listening_for_wake_word = False

def prompt_gpt(audio):
    global listening_for_wake_word
    try:
        with open("prompt.wav","wb") as f:
            f.write(audio.get_wav_data())
        result = base_model.transcribe('prompt.wav')
        prompt_text = result['text']
        if (prompt_text.strip()) == 0:
            print("No prompt detected. Please speak again.")
            speak('No prompt detected. Please speak again.')
            listening_for_wake_word = True
        else:
            print('User: '+ prompt_text)
            output = model.generate(prompt_text,max_tokens=200)
            print('Jarvis: '+ output)
            speak(output)
            print('\nSay', wake_word, 'to wake me up. \n')
            listening_for_wake_word = True
    except Exception as e:
        print("Prompt error: ",e)

def callback(recognizer, audio):
    global listening_for_wake_word
    if listening_for_wake_word:
        listen_for_wake_word(audio)
    else:
        prompt_gpt(audio)

def start_listening():
    with source as s:
        r.adjust_for_ambient_noise(s,duration=2)
        print('\nSay', wake_word, 'to wake me up. \n')
        r.listen_in_background(source, callback)
        while True:
            time.sleep(1)

if __name__ == "__main__":
    start_listening()



