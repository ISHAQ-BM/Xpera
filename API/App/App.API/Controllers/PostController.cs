﻿using App.API.AuthenticationService;
using App.API.Services.Interfaces;
using App.Models.Dtos.Post.Create;
using App.Models.Dtos.Post.Read;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace App.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PostController(ICommandService commandService, IQueryService queryService) : ControllerBase
    {
        private readonly ICommandService _commandService = commandService;
        private readonly IQueryService _queryService = queryService;

        [HttpGet("{id}")]
        public async Task<ActionResult<PostReadFullDto>> GetPost(int id)
        {
            PostReadFullDto? post = await _queryService.ReadPostAsync(id);
            if(post == null)
            {
                return NotFound();
            }
            else
            {
                return Ok(post);
            }
        }

        [HttpGet("User_Id/{user_Id}")]
        public async Task<ActionResult<IEnumerable<PostReadFullDto>>> GetUserPosts(int user_Id)
        {
            return Ok( await _queryService.ReadUserPostsAsync(user_Id) );

        }

        [HttpGet("tag/{tag_Id}")]
        public async Task<ActionResult<IEnumerable<PostReadFullDto>>> GetTagPosts(int tag_Id)
        {
            return Ok(  await _queryService.ReadTagPostsAsync(tag_Id) );
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<PostReadFullDto>>> GetAllPosts()
        {
            return Ok( await _queryService.ReadAllPostsAsync() );
        }

        [HttpPost]
        [Authorize(Policy =Auth.Policy.RequireUser)]
        public async Task<ActionResult<PostReadMinimulDto>> CreateNewPost([FromBody] PostCreateDto postCreate)
        {
            return Ok( await _commandService.PostCreateAsync(postCreate) );
        }

        [HttpDelete("{post_id}")]
        [Authorize(Policy = Auth.Policy.RequireUser)]
        public async Task<ActionResult> DeletePost(int post_id)
        {
            if(await _commandService.PostDeleteAsync(post_id))
            {
                return Ok();
            }
            else
            {
                return NotFound();
            }
        }

    
    }
}
