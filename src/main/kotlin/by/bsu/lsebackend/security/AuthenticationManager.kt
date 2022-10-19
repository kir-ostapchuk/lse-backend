package by.bsu.lsebackend.security

import by.bsu.lsebackend.entity.UserRole
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

private const val ROLE = "role"

@Component
class AuthenticationManager(private val tokenService: TokenService) : ReactiveAuthenticationManager {
    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        val authToken = authentication.credentials.toString()
        return tokenService.isValid(authToken)
            .map {
                val claims = tokenService.retrieveClaims(authToken)
                claims.get(ROLE, ArrayList::class.java)
            }.map { roles ->
                val authenticationToken: Authentication = UsernamePasswordAuthenticationToken(
                    tokenService.retrieveUsername(authToken),
                    null,
                    roles.map { UserRole.valueOf(it.toString()).getAuthority() }
                )
                return@map authenticationToken
            }.switchIfEmpty(Mono.empty())
    }
}
