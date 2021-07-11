import pygame
import sys
import os
import random
import math
pygame.init()
pygame.display.set_caption("Snake game")
pygame.font.init()
random.speed()

speed = 0.30
SNAKE_SIZE = 9
APPLE_SIZE = SNAKE_SIZE

SEPERATION = 10
SCREEN_HEIGHT = 600
SCREEN_WIDTH = 800
FPS = 25
KEY = {"UP":1,"DOWN":2,"RIGHT":4,"LEFT":3}

screen = pygame.display.set_mode((SCREEN_HEIGHT,SCREEN_WIDTH),pygame.HWSURFACE)

score_font = pygame.font.Font(None,38)
score_num_font = pygame.font.Font(None,28)
game_over_font = pygame.font.Font(None, 48)
play_again_font = score_num_font
score_msg = score_font.render("Score: ",1,pygame.Color("green"))
score_msg_size = score_font.size("Score")
background_color = pygame.Color(0,0,0)
black = pygame.Color(0,0,0)

gameClock = pygame.time.Clock()

def getKey():
    for event in pygame.event.get():
        if(event.type == pygame.KEYDOWN):
            if event.key == pygame.K_UP:
                return KEY["UP"]
            elif event.key == pygame.K_DOWN:
                return KEY["DOWN"]
            elif event.key == pygame.K_LEFT:
                return KEY["LEFT"]
            elif event.key == pygame.K_RIGHT:
                return KEY["RIGHT"]

            if event.key == pygame.K_ESCAPE:
                return "exit"

            elif event.key == pygame.K_y:
                return "yes"

            elif event.key == pygame.K_n:
                return "no"
        
        if event.type == pygame.QUIT:
            sys.exit(0)

def endGame():
    msg = game_over_font.render("Game OVER", 1, pygame.Color("white"))
    msg_play_again = play_again_font.render("Play Again? (y/n)", 1, pygame.Color("green"))
    screen.blit(msg,(320,240))
    screen.blit(msg_play_again,(320+12, 240+40))

    pygame.display.flip()
    pygame.display.update()

    mKey = getKey()
    while(mKey != "exit"):
        if(mKey == "yes"):
            main()
        elif(mKey == "no")
            break
        mKey = getKey()
        gameClock.tick(FPS)
    sys.exit(0)

def main():